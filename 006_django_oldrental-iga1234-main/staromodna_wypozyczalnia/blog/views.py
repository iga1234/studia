from django.shortcuts import redirect
from .models import Book
from .models import Film
from .models import CD
from django.urls import reverse_lazy
from django.views.generic import ListView, TemplateView, CreateView, UpdateView, DeleteView, DetailView


class MainView(TemplateView):
    template_name = 'blog/main_view.html'

class BookListView(ListView):
    model = Book

class FilmListView(ListView):
    model = Film

class CDListView(ListView):
    model = CD

class AddBookView(CreateView):
    model = Book
    fields = ['title', 'author', 'type', 'ISBN']
    success_url = reverse_lazy('book_list')

class AddFilmView(CreateView):
    model = Film
    fields = ['title', 'director', 'type', 'time']
    success_url = reverse_lazy('film_list')

class AddCdView(CreateView):
    model = CD
    fields = ['title', 'band', 'type', 'tracks', 'time']
    success_url = reverse_lazy('cd_list')

class DeleteBookView(DeleteView):
    model = Book
    success_url = reverse_lazy('book_list')

class DeleteConfirmationView(TemplateView):
    model = Book
    template_name = '_confirm_delete.html'

class UpdateBookView(UpdateView):
    model = Book
    fields = ['title', 'author', 'type', 'ISBN']
    template_name_suffix = '_update_form'
    success_url = reverse_lazy('book_list')

class DeleteCdView(DeleteView):
    model = CD
    success_url = reverse_lazy('cd_list')

class DeleteFilmView(DeleteView):
    model = Film
    success_url = reverse_lazy('film_list')

class UpdateFilmView(UpdateView):
    model = Film
    fields = ['title', 'director', 'type', 'time']
    template_name_suffix = '_update_form'
    success_url = reverse_lazy('film_list')

class UpdateCdView(UpdateView):
    model = CD
    fields = ['title', 'band', 'type', 'tracks', 'time']
    template_name_suffix = '_update_form'
    success_url = reverse_lazy('cd_list')


class ProfileView(ListView):
    context_object_name = 'name'
    template_name = 'blog/my_profile.html'
    queryset = Book.objects.all().filter(rent='user')

    def get_context_data(self, **kwargs):
        context = super(ProfileView, self).get_context_data(**kwargs)
        context['films'] = Film.objects.all().filter(rent='user')
        context['cds'] = CD.objects.all().filter(rent='user')
        context['books'] = Book.objects.all().filter(rent='user')
        return context

class RentBookView(CreateView):

    def post(self, request, *args, **kwargs):
        category = kwargs.get('category')
        if category == 'book':
            item = Book.objects.get(pk=kwargs.get('pk'))
        elif category == 'film':
            item = Film.objects.get(pk=kwargs.get('pk'))
        elif category == 'cd':
            item = CD.objects.get(pk=kwargs.get('pk'))
        item.rent = 'user'
        item.save()
        return redirect('/'+category+'s')


class ReturnBookView(CreateView):

    def post(self, request, *args, **kwargs):
        category = kwargs.get('category')
        if category == 'book':
            item = Book.objects.get(pk=kwargs.get('pk'))
        elif category == 'film':
            item = Film.objects.get(pk=kwargs.get('pk'))
        elif category == 'cd':
            item = CD.objects.get(pk=kwargs.get('pk'))
        item.rent = None
        item.save()
        return redirect('/profile')




