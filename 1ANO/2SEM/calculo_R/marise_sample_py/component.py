import psutil as ps


def cpu_freq():
    return round(ps.cpu_freq().current, 1)


def ram_usage():
    return round((ps.virtual_memory().total - ps.virtual_memory().available) / 1024 ** 3, 1)


def temp():
    return round(ps.sensors_temperatures()['acpitz'][0].current, 1)


def disco_percent():
    return round(ps.disk_usage('/').percent, 1)


def index_comp(component):

    if (component == 'cpu'):
        return cpu_freq()
    elif (component == 'ram'):
        return ram_usage()
    elif (component == 'disco'):
        return disco_percent()
    elif (component == 'temp'):
        return temp()
    else:
        return 0
