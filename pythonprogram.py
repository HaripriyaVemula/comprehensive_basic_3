import math

class CircleComp:
    radius = float(input("Enter the circle's radius: "))
    diameter = radius * 2.0 
    circumference=2.0*math.pi*radius
    area = math.pi * diameter
    print("Diameter:", diameter)
    print("Area:", area)
