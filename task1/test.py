import function_parser


def test_convert_equation():
    assert function_parser.convert_equation("x^2") == "x**2"
    assert function_parser.convert_equation("") is None
    assert function_parser.convert_equation("x--2") == "x+2"
    assert function_parser.convert_equation("x---2") == "x-2"


def test_evaluate_function():
    assert function_parser.substitute("x**2", 5) == 25
    assert function_parser.substitute("y**2", 5) is None
    assert function_parser.substitute("x-2", 5) == 3


def test_validate_min_max():
    assert function_parser.validate_min_max(5,3) is False
    assert function_parser.validate_min_max(3,5) is True


test_convert_equation()
test_evaluate_function()
test_validate_min_max()
print("passed all tests  ")
