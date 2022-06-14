from World import World
from Position import Position
from Organisms.Grass import Grass
from Organisms.Sheep import Sheep
from Organisms.Antelope import Antelope
from Organisms.Lynx import Lynx
import os


if __name__ == '__main__':
	pyWorld = World(10, 10)

	newOrg = Grass(position=Position(xPosition=9, yPosition=9), world=pyWorld)
	pyWorld.addOrganism(newOrg)

	newOrg = Grass(position=Position(xPosition=1, yPosition=1), world=pyWorld)
	pyWorld.addOrganism(newOrg)

	newOrg = Sheep(position=Position(xPosition=2, yPosition=2), world=pyWorld)
	pyWorld.addOrganism(newOrg)

	newOrg = Antelope(position=Position(xPosition=3, yPosition=3), world=pyWorld)
	pyWorld.addOrganism(newOrg)

	newOrg = Lynx(position=Position(xPosition=4, yPosition=4), world=pyWorld)
	pyWorld.addOrganism(newOrg)

	print(pyWorld)

	for _ in range(0, 50):
		choice = input("Wywołaj plagę na 2 tury.(P)\n"
					   "Dodaj nowy organizm.(O)\n"
					   "Nastepna tura('Enter')\n")
		if choice.upper() == 'P':
			for i in range(2):
				input('')
				os.system('cls')
				pyWorld.plague()
				pyWorld.makeTurn()
				print(pyWorld)
				_ += 1
		elif choice.upper() == "O":
			points = ''
			Org = input("Wybierz organizm: 'Grass', 'Sheep', 'Antelope', 'Lynx'.\n")
			while not points:
				x = int(input(("Wskaż pozycję(x):")))
				y = int(input(("Wskaż pozycję(y):")))
				points = pyWorld.check(x,y)
				if points:
					new = pyWorld.newOrg(Org, x, y)
					pyWorld.addOrganism(new)
					print(pyWorld)

		else:
			input('')
			os.system('cls')
			pyWorld.makeTurn()
			print(pyWorld)

