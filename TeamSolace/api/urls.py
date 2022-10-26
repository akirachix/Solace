
from django.urls import path
from . import views
urlpatterns = [
    path('client/',views.ClientRegisterViewSet.as_view(), name='clients' ),
    path('login/', views.LoginAPI.as_view(), name='login'),
    #  path('register/',views.ClientRegisterViewSet.as_view(), name='register'),
    # path('discovery/',views.DiscoveryListViewset.as_view(), name='discovery' ),
    # path('user/logout/', knox_views.LogoutView.as_view(), name='logout'),
    # path('user/logoutall/', knox_views.LogoutAllView.as_view(), name='logoutall'),
]
