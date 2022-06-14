from django.urls import path
from blog import views
from django.contrib.auth.views import LoginView
from django.contrib.auth.views import LogoutView
from .views import BookListView
from .views import MainView
from .views import CDListView
from .views import FilmListView
from .views import AddBookView
from .views import AddFilmView
from .views import AddCdView
from .views import DeleteBookView, UpdateBookView, ReturnBookView
from .views import DeleteCdView, UpdateCdView
from .views import DeleteFilmView, UpdateFilmView
from .views import DeleteConfirmationView, ProfileView, RentBookView



urlpatterns = [
    path('', MainView.as_view(), name='main_view'),
    path('book/new', AddBookView.as_view(), name='book_new'),
    path('film/new', AddFilmView.as_view(), name='film_new'),
    path('cd/new', AddCdView.as_view(), name='cd_new'),
    path('book/<int:pk>/update/', UpdateBookView.as_view(), name='book_update'),
    path('cd/<int:pk>/update/', UpdateCdView.as_view(), name='cd_update'),
    path('film/<int:pk>/update/', UpdateFilmView.as_view(), name='film_update'),
    path('login', LoginView.as_view(), name='login'),
    path('logout', LogoutView.as_view(template_name="registration/logout.html"),name="logout"),
    path('films', FilmListView.as_view(), name='film_list'),
    path('books', BookListView.as_view(),name='book_list'),
    path('cds', CDListView.as_view(), name='cd_list'),
    path('book/<int:pk>/delete', DeleteBookView.as_view(), name='book_delete'),
    path('film/<int:pk>/delete', DeleteFilmView.as_view(), name='film_delete'),
    path('cd/<int:pk>/delete', DeleteCdView.as_view(), name='cd_delete'),
    path('conf/', DeleteConfirmationView.as_view(), name="confirm_delete"),
    path('profile/', ProfileView.as_view(), name='my_profile'),
    path('rent/<int:pk>/<str:category>', RentBookView.as_view(), name='rent'),
    path('return/<int:pk>/<str:category>', ReturnBookView.as_view(), name='return')
]