import sys
import fileinput
import csv

f = open('rawdata.txt', 'r')

x = []
y = []


for line in f.readlines():
    a = line.find('x')
    b = line.find(',') 
    first = line[a:b]   
    c = line.find('y')    
    d = line.find(']')
    second = line[c:d]
    x.append(first)
    y.append(second)


