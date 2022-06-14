from django import forms
from .models import Book
from .models import Film
from .models import CD

class BookForm(forms.ModelForm):

    class Meta:
        model = Book
        fields = ('title', 'author', 'type', 'ISBN')


class FilmForm(forms.ModelForm):

    class Meta:
        model = Film
        fields = ('director', 'title', 'type', 'time')



class CDForm(forms.ModelForm):

    class Meta:
        model = CD
        fields = ('band','title', 'type', 'tracks','time')


