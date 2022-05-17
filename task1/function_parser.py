


def convert_equation(function):
    """
    convert the entered equation to the accepted formula by eval()
    :param function:String
    :return:String or None in case of empty String
    """

    splitted = list(function)
    if len(splitted) == 0:
        return None
    equation=""
    previous_negative = False
    i = 0
    while i < len(splitted):
        if splitted[i] == '^':
            print(splitted[i])
            equation+="**"
        elif splitted[i] == '-':
            count = 1
            i+=1
            while i < len(splitted) and splitted[i] == '-' :
                count += 1
                i += 1
            i-=1
            if count % 2 == 0:
                equation += "+"
            else:
                equation += "-"
        else:
            equation+=splitted[i]
        i+=1
    return equation


def evaluate_points(function,min,max):
    """
    evaluate (max-min)*1000 points
    :param function:String
    :param min:float
    :param max:flaot
    :return: list
    """
    point_num = 1000
    step =1/point_num
    xlist=[min+i*step for i in range(int(max-min)*point_num)]
    ylist=[substitute(function,x)for x in xlist ]
    points=[xlist,ylist]
    return points


def substitute(function,x):
    """substitute the given x value in the equation
    :argument
        x:float
    :returns
        val:float or None in case of invalid equation
    """
    try:
        val = eval(function, {"x": x})
        return val
    except (SyntaxError, NameError):
        return None



def validate_min_max(min_val,max_val):
    return min_val <max_val

