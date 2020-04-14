# Python basic skills Practice problems
# 1. Category -> [
#                 Expression          (https://wikidocs.net/42526),
#                 Simple Statements   (https://wikidocs.net/42527),
#                 Compound statements (https://wikidocs.net/42528)
#                ]
# 2. Executor is one, Modules for Category
# 3.

# Import Modules
from modules import *


def main_execute():
    index = 1
    print("=========================")
    for category in Constants.FUNCTION_LIST.keys():
        print("%2d - %s" % (index, category))
        index += 1

    print("=========================")
    clt_category = list(Constants.FUNCTION_LIST.keys())[int(input("Input Function number -> ")) - 1]

    index = 1
    print("=========================")
    for sub_menu in Constants.FUNCTION_LIST.get(clt_category):
        print("%2d - %s" % (index, sub_menu))
        index += 1

    print("=========================")
    clt_sub_menu = Constants.FUNCTION_LIST.get(clt_category)[int(input("Input Sub Menu number -> ")) - 1]
    prob_factory = ProblemFactory(clt_category, clt_sub_menu)
    prob_factory.execute()


if __name__ == "__main__":
    main_execute()
