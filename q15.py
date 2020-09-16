# by Arad Firoozkuhi






susStr = ""
good_boy_points = 0
import re


def compare(key: str):
    global good_boy_points, susStr
    if key == susStr:
        good_boy_points += 1


def length(count: int):
    global good_boy_points, susStr
    if len(susStr) == count:
        good_boy_points += 1


def copy(key: str, count: int):
    global good_boy_points, susStr
    new_str = key * count
    susStr = new_str + susStr[len(new_str):]


def substrCountOverlap(string: str, sub_str: str) -> int:
    results = 0
    sub_len = len(sub_str)
    for i in range(len(string)):
        if string[i:i + sub_len] == sub_str:
            results += 1
    return results


def substr(key: str, count: int):
    global good_boy_points, susStr
    if substrCountOverlap(susStr, key) == count:
        good_boy_points += 1


def attach(key: str, count: int, str_str: str):
    global good_boy_points, susStr
    if substrCountOverlap(susStr, key + str_str) == count:
        good_boy_points += 1


def main_func():
    global susStr, good_boy_points
    susStr = input()
    good_boy_points = 0
    current_gbp = 0
    while True:

        input_command = input()
        if input_command == "Is it right or not?":
            print("Eyval" if good_boy_points >= current_gbp / 2 else "HeifShod")
            break
        input_command = input_command.split(" ")
        if input_command[0] == "length":
            length(int(input_command[1]))
        elif input_command[0] == "copy":
            copy(input_command[1], int(input_command[2]))
        elif input_command[0] == "compare":
            compare(input_command[1])
        elif input_command[0] == "substr":
            substr(input_command[1], int(input_command[2]))
        elif input_command[0] == "attach":
            attach(input_command[1], int(input_command[2]), input_command[3])
        current_gbp += 1


main_func()
