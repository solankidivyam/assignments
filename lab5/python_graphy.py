import matplotlib.pyplot as plt 

# line 1 points 
x1 = [2000,4000,6000,8000,10000] 
y1 = [2873,2987,3167,3233,3467] 
# plotting the line 1 points 
plt.plot(x1, y1, label = "Heap Sort") 

# line 2 points 
x2 = [2000,4000,6000,8000,10000] 
y2 = [794,995,1343,1919,2448] 
# plotting the line 2 points 
plt.plot(x2, y2, label = "Heap Deletion") 

# line 3 points
x3 = [2000,4000,6000,8000,10000] 
y3 = [4460,5151,5533,6061,6522]
#plotting line 3
plt.plot(x3, y3, label = "Heap Insertion") 

# naming the x axis 
plt.xlabel('x - axis / no. of elements') 
# naming the y axis 
plt.ylabel('y - axis / time in microseconds') 
# giving a title to my graph 
plt.title('Two lines on same graph!') 

# show a legend on the plot 
plt.legend() 

# function to show the plot 
plt.show() 
