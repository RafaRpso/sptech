#inicializando pastas 
cd ~ 
mkdir aulaso 
cd aulaso
touch atividade.txt
echo "Olá rafael !!! " > atividade.txt
mkdir testeBatch 
mv atividade.txt testeBatch/ 
cd testeBatch
ls -l 

#escalonamento de permissao
chmod 555 atividade.txt
chmod 644 atividade.txt
chmod 400 atividade.txt
chmod 777 atividade.txt
chmod 421 atividade.txt

#programa para aqui, mudando usuario
sudo adduser rafaelraposo2
sudo su rafaelraposo2 
cd ~/testeBatch/ 
cat atividade.txt
exit 


#escalonando permissao
chmod 744 atividade.txt

#trocando usuario 
sudo su rafaelraposo2 
sudo usermod -aG cco rafaelraposo2 
ls -l 
cd ~/testeBatch/ 
cat atividade.txt
mv atividade.txt atividade2.txt


#deletando arquivos 
rm -rfv atividade2.txt
cd .. 
rm -rfv testeBatch 
sudo userdel -r rafaelraposo2 
sudo groupdel -f cco 



