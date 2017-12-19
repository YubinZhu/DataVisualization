import numpy as np
import json
from netCDF4 import Dataset

nc_file = '../src/precip.nc'
proj_precip = Dataset(nc_file,'r')

def store(data):
    with open('data.json', 'w') as json_file:
        json_file.write(json.dumps(data))

if __name__ == "__main__":
    time = proj_precip.variables['time'][:]
    latitude = proj_precip.variables['lat'][:]
    longtitude = proj_precip.variables['lon'][:]
    precip = proj_precip.variables['precip'][:]

    data = []

    for i in range(-10,1):#3 years
        sdata = {}
        sdata['time'] = time[time.size-1+i]#time
        sdata['lat'] = latitude.tolist()
        sdata['lon'] = longtitude.tolist()
        sdata['precip'] = precip[time.size-1+i].tolist()
        data.append(sdata)

    store(data)



