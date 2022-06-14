from .Animal import Animal
from Position import Position
from Organisms.Lynx import Lynx
import random
from Action import Action
from ActionEnum import ActionEnum

class Antelope(Animal):

	def __init__(self, antelope=None, position=None, world=None):
		super(Antelope, self).__init__(antelope, position, world)

	def clone(self):
		return Antelope(self, None, None)

	def initParams(self):
		self.power = 4
		self.initiative = 3
		self.liveLength = 11
		self.powerToReproduce = 5
		self.sign = 'A'

	def move(self):
		result = []
		oldPosition = Position(xPosition=self.position.x, yPosition=self.position.y)
		newPosition = None
		pomPositions = None

		pomPositions = self.world.farFromLynx(self.world.getNeighboringPositions(oldPosition), oldPosition)
		if pomPositions:
			newPosition = pomPositions[0]
			result.append(Action(ActionEnum.A_MOVE, newPosition, 0, self))
			self.lastPosition = oldPosition
			metOrganism = self.world.getOrganismFromPosition(newPosition)
			if metOrganism is not None:
				result.extend(metOrganism.consequences(self))
			return result

		elif not pomPositions:
			pomPositions = self.world.filterPositionsWithoutAnimals(self.world.getNeighboringPositions(self.position))
			if pomPositions:
				newPosition = random.choice(pomPositions)
				result.append(Action(ActionEnum.A_MOVE, newPosition, 0, self))
				self.lastPosition = oldPosition
				metOrganism = self.world.getOrganismFromPosition(newPosition)
				if metOrganism is not None:
					result.extend(metOrganism.consequences(self))
			return result



