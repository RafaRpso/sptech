//const : valor nao pode mudar com if nem condicoes futuras

const serialport = require('serialport'); //porta do sistema
const express = require('express'); 
const mysql = require('mysql2'); // requisicao mysql2
const SERIAL_BAUD_RATE = 9600; // rate
const SERVIDOR_PORTA = 3000; //porta do servidor
const HABILITAR_OPERACAO_INSERIR = false; // nao pode inserir

//importante depois
const serial = async (
    valoresDht11Umidade,
    valoresDht11Temperatura,
    valoresLuminosidade,
    valoresLm35Temperatura,
    valoresChave
) => {
    const poolBancoDados = mysql.createPool(
        {
            host: 'localhost', //criacao do servidor do banco
            port: 3306, //porta do banco
            user: 'root', // usuario 
            password: 'urubu100', //senha 
            database: 'metricas' // nome do banco => use metricas
        }
    ).promise();

    const portas = await serialport.SerialPort.list();
    const portaArduino = portas.find((porta) => porta.vendorId == 2341 && porta.productId == 43);
    if (!portaArduino) { //se porta arduino = falso mostre : 
        throw new Error('O arduino não foi encontrado em nenhuma porta serial');
    }
    const arduino = new serialport.SerialPort(
        {
            path: portaArduino.path,
            baudRate: SERIAL_BAUD_RATE
        }
    );
    arduino.on('open', () => { // sse o arduino está ligado, ele mostra
        console.log(`A leitura do arduino foi iniciada na porta ${portaArduino.path} utilizando Baud Rate de ${SERIAL_BAUD_RATE}`);
    });
    arduino.pipe(new serialport.ReadlineParser({ delimiter: '\r\n' })).on('data', async (data) => {
        const valores = data.split(';');//valores do arduino
        const dht11Umidade = parseFloat(valores[0]); //vetor, na posicao 0, recebe
        const dht11Temperatura = parseFloat(valores[1]); //vetor, na posicao 1, recebe
        const luminosidade = parseFloat(valores[2]); // vetor, na posicao 2, recebe
        const lm35Temperatura = parseFloat(valores[3]); // vetor, na posicao 3, recebe
        const chave = parseInt(valores[4]); // vetor, na posicao 4, recebe 

        valoresDht11Umidade.push(dht11Umidade); 
        valoresDht11Temperatura.push(dht11Temperatura);
        valoresLuminosidade.push(luminosidade);
        valoresLm35Temperatura.push(lm35Temperatura);
        valoresChave.push(chave); // o método push serve pra puxar um valor de um vetor, aqui, ele puxa o vetor onde se encontra o valor da variavel chave. 

        if (HABILITAR_OPERACAO_INSERIR) { // se for verdadeiro, ele insere os dados na tabela sensores
            await poolBancoDados.execute( // await é uma condição para esperar por um valor
                'INSERT INTO sensores (dht11_umidade, dht11_temperatura, luminosidade, lm35_temperatura, chave) VALUES (?, ?, ?, ?, ?)', //inserção de dados no mysql via npm 
                [dht11Umidade, dht11Temperatura, luminosidade, lm35Temperatura, chave] //inserção dos valores de cada variavel nas partes ? ? ? ? do código 
            );
        }

    });
    arduino.on('error', (mensagem) => { //imprimir erro 
        console.error(`Erro no arduino (Mensagem: ${mensagem}`)
    });
}

const servidor = ( // a declaração desse servidor é cada um dos valores
    valoresDht11Umidade, //cada valor recebe uma variavel (que recebe um valor do vetor valores) 
    valoresDht11Temperatura,
    valoresLuminosidade,
    valoresLm35Temperatura,
    valoresChave
) => {
    const app = express();
    app.use((request, response, next) => {
        response.header('Access-Control-node Allow-Origin', '*'); // no idea 
        response.header('Access-Control-Allow-Headers', 'Origin, Content-Type, Accept');
        next(); // retorna a possibilidade de cada um dos valores
    });
    app.listen(SERVIDOR_PORTA, () => {
        console.log(`API executada com sucesso na porta ${SERVIDOR_PORTA}`); 
    });
    app.get('/sensores/dht11/umidade', (_, response) => {
	// retorna o valor do sensor
        return response.json(valoresDht11Umidade); //umidade
    });
    app.get('/sensores/dht11/temperatura', (_, response) => {
        //mesma coisa, mas pro sensor de temperatura
	return response.json(valoresDht11Temperatura);//temp
    });
    app.get('/sensores/luminosidade', (_, response) => {
        return response.json(valoresLuminosidade); //luminosidade
    });
    app.get('/sensores/lm35/temperatura', (_, response) => {
        return response.json(valoresLm35Temperatura);//lm35 temp
    });
    app.get('/sensores/chave', (_, response) => {
        return response.json(valoresChave);//chave/bloqueio
    });
}

(async () => {
	//do vetor async declarado acima 
    const valoresDht11Umidade = []; // declaracao vetores  para cada sensor 
    const valoresDht11Temperatura = [];
    const valoresLuminosidade = [];
    const valoresLm35Temperatura = [];
    const valoresChave = [];
    await serial(
        valoresDht11Umidade,
        valoresDht11Temperatura,
        valoresLuminosidade,
        valoresLm35Temperatura,
        valoresChave
    ); 
    servidor(
        valoresDht11Umidade,
        valoresDht11Temperatura,
        valoresLuminosidade,
        valoresLm35Temperatura,
        valoresChave
    );
})();
