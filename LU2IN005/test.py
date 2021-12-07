# -*- coding: utf-8 -*-
"""
Code modifiable.
"""

from automate import Automate
from state import State
from transition import Transition
from myparser import *

automate = Automate.creationAutomate("exempleAutomate.txt")
s0 = State(0, True, False)
s1 = State(1, False, False)
s2 = State(2, False, False)
s3 = State(3, False, True)
s4 = State(4, True, False)

t_list = automate.getListTransitionsFrom(s0)
for transition in t_list:
    print(transition.etiquette)

# # test function : accepte
# print(Automate.accepte(automate, 'baaa'))

