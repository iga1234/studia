from django.db import models




class Book(models.Model):
    author = models.CharField(max_length=200, null=False)
    title = models.CharField(max_length=200, null=False)
    type = models.CharField(max_length=200, null=False)
    ISBN = models.PositiveIntegerField(unique=True)
    rent = models.CharField(max_length=20, null=True)



class Film(models.Model):
    director = models.CharField(max_length=200, null=False)
    title = models.CharField(max_length=200, null=False)
    type = models.CharField(max_length=200, null=False)
    time = models.PositiveSmallIntegerField(null=False)
    rent = models.CharField(max_length=20, null=True)



class CD(models.Model):
    band = models.CharField(max_length=200, null=False)
    title = models.CharField(max_length=200, null=False)
    type = models.CharField(max_length=200, null=False)
    tracks = models.CharField(max_length=500, null=False)
    time = models.CharField(max_length=6, null=False)
    rent = models.CharField(max_length=20, null=True)

