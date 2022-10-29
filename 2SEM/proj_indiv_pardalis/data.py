import psutil as ps
import os


class GetData:

    def __init__(self):
        self.author = "Rafael"

    def count_process(self):

        command = os.popen('ps aux').read()
        count = 0

        for i in command:
            if i == '\n':
                count += 1
        return count

    def define_data(self):
        self.percent_cpu = int(ps.cpu_percent())
        self.percent_ram = ps.virtual_memory().percent
        self.percent_disk = ps.disk_usage('/').percent

    def get_cpu_freq():
        return ps.cpu_freq().current

    def get_cpu_percent():
        return round(ps.cpu_freq().current * 100 / ps.cpu_freq().max)

    def get_total_ram():
        return ps.virtual_memory().total / 1024 ** 3

    def get_use_ram():
        return ps.virtual_memory().used / (1024**3)

    def get_percent_ram():
        return ps.virtual_memory().percent

    def get_total_disk():
        return round(ps.disk_usage('/').total / (1024**3))

    def get_used_disk():
        return round(ps.disk_usage('/').used / (1024**3))

    def get_percent_disk():
        return ps.disk_usage('/').percent

    def metrica_risco(self):
        GetData.define_data(self)

        condicao = {'cpu': '', 'ram': '', 'disco': ''}

        if (self.percent_cpu < 60):
            condicao.update({'cpu': 'Baixo uso'})
        elif (self.percent_cpu >= 60 & self.percent_cpu <= 80):
            condicao.update({'cpu': 'Ideal'})
        else:
            condicao.update({'cpu': 'Risco de lentidão'})

        if (self.percent_ram < 60):
            condicao.update({'ram': 'Ideal'})
        elif (self.percent_cpu >= 60 & self.percent_cpu <= 90):
            condicao.update({'ram': 'Risco de gargalo'})
        else:
            condicao.update({'ram': 'Alto risco: Verificar aplicações'})

        if (self.percent_disk < 60):
            condicao.update({'disco': 'Ideal'})
        elif (self.percent_cpu >= 60 & self.percent_cpu <= 90):
            condicao.update({'ram': 'Risco de lotação'})
        else:
            condicao.update({'ram': 'Alerta de lotação'})

        return condicao
