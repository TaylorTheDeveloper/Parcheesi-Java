import sys
import fileinput
import csv

f = open('rawdata.txt', 'r')

x = []
y = []


for line in f.readlines():
    a = line.find('x')
    b = line.find(',') 
    first = line[a+2:b]   
    c = line.find('y')    
    d = line.find(']')
    second = line[c+2:d]
    x.append(first)
    y.append(second)

string = "Point[] pointData = {"

for i in range(len(x)):
	string+="\nnew Point(" + x[i] + "," + y[i] + "), "

string += "}"

print string


