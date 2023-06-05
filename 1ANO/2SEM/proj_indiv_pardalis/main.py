import os
import time
from data import GetData

machine = GetData


def apresentacao_uso(uso_cpu, uso_ram, uso_disco):
    print(f"Uso CPU: {uso_cpu}%")
    print(f"Uso RAM: {uso_ram}%")
    print(f"Uso Disco: {uso_disco}%")


def apresentacao_metricas():
    print(f"""      CPU                 RAM                    DISCO
 {machine.metrica_risco(machine)['cpu']}                {machine.metrica_risco(machine)['ram']}       {machine.metrica_risco(machine)['disco']}
    """)


def apresentacao_data():
    print("""                       .___      .__  .__        
___________ _______  __| _/____  |  | |__| ______
\____ \__  \\_  __ \/ __ |\__  \ |  | |  |/  ___/
|  |_> > __ \|  | \/ /_/ | / __ \|  |_|  |\___ \ 
|   __(____  /__|  \____ |(____  /____/__/____  >
|__|       \/           \/     \/             \/   """)

    print('==========================================================')

    print('\n')
    
    print('============================================================')
    print('\n')
    print(f"Processos ativos: {machine.count_process(machine)}")
    apresentacao_uso(machine.get_cpu_percent(),
                     machine.get_percent_ram(), machine.get_percent_disk())
    print('\n')


def clear():
    return os.system('clear')


def main():
    clear()
    apresentacao_data()
    apresentacao_metricas()
    time.sleep(1)
    clear()
    main()


main()
