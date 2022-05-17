import tkinter as tk
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from matplotlib.figure import Figure
import function_parser


class GUI:
    window = tk.Tk()
    equation = tk.Entry(window, width=100)
    min= tk.Entry(window, width=10)
    max = tk.Entry(window, width=10)
    canvas = tk.Canvas(window, width=400, height=400)
    error_label = tk.Label(window, text="",fg='#FF0000')
    error_label.grid(row=7,pady=2)

    def get_equation(self):
        """get the entered equation and convert it to be accepted by eval()
        :returns
            parsed_eqaution :String

        """
        entered_equation = self.equation.get()
        return function_parser.convert_equation(entered_equation)

    def get_min_val(self):
        """
        get the entered min value
        :return: float or None in case of invalid input
        """
        try:
            min_val=float(self.min.get())
            return min_val
        except:
            self.set_error_msg("invalid min value")
            return None

    def get_max_val(self):
        """
        get the entered max value
        :return: float or None in case of invalid input
        """
        try:
            max_val=float(self.max.get())
            return max_val
        except:
            self.set_error_msg("invalid max value")
            return None

    def plot_equation(self):
        #get the entered values
        self.set_error_msg(" ")
        parsed_equation = self.get_equation()
        if parsed_equation is None:
            self.set_error_msg("invalid equation")
            return
        min_val = self.get_min_val()
        max_val = self.get_max_val()
        #validate the entered values
        if min_val is None or max_val is None:
            return
        if not function_parser.validate_min_max(min_val, max_val):
            self.set_error_msg("max value cannot be less than min value")
            return
        points = function_parser.evaluate_points(parsed_equation, min_val, max_val)
        for y in points[1]:
            if y is None:
                self.set_error_msg("Invalid equation")
                return
        #plot the evaluated points
        self.plot(points)

    def set_error_msg(self, msg):
        """
        set the error label to the associated error msg
        :param msg: String
        """
        self.error_label.config(text=msg,font=("Arial",15))

    def plot(self, points):
        """
        plot function takes a points List consist of x_list,y_list and plot them against each other within a figure in the canvas widget
        :param points: List
        """
        fig = Figure(figsize=(6, 6))
        a = fig.add_subplot(111)
        a.set_title("function Plot", fontsize=16)
        a.set_ylabel("Y", fontsize=14)
        a.set_xlabel("X", fontsize=14)
        a.plot(points[0], points[1])
        canvas = FigureCanvasTkAgg(fig, master=self.window)
        canvas.get_tk_widget().grid(row=4)
        canvas.draw()

    def close_win(self):
        """
        close the program
        """
        self.window.destroy()

    def __init__(self):
        self.window.title("Plotter")
        self.window.geometry("1500x2000")
        self.window.minsize(1500,2000)
        self.window.grid_columnconfigure((0,1),weight=2)
        equation_label = tk.Label(self.window, text="Equation").grid(row=0, sticky=tk.W, pady=2)
        self.equation.grid(row=0, column=1)
        self.equation.place(x=300,y=10)
        min_label = tk.Label(self.window, text="Min").grid(row=2,column=0 , sticky=tk.W, pady=2)
        max_label = tk.Label(self.window, text="Max").grid(row=3, column=0, sticky=tk.W, pady=2)
        self.min.grid(row=2, column=1)
        self.max.grid(row=3, column=1)
        self.max.place(x=300,y=50)
        self.min.place(x=300,y=30)
        self.canvas.grid(row=4,column=0)
        plot_button = tk.Button(self.window, text='plot', width=25, command=lambda: self.plot_equation())
        plot_button.grid(row=6,column=0)
        close_button = tk.Button(self.window, text='close', width=25, command=lambda: self.close_win())
        close_button.grid(row=9,column=0)
        self.window.mainloop()