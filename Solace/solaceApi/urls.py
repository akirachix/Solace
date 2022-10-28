from django import views
from django.urls import path, include
from Solace.solaceapp import admin
from rest_framework import routes
from .views import *

router =routes.DefaultRouter()
# router.register(r"Register",RegisterAPI)
router.register(r"Client",ClientCreateView)
router.register(r"Chatbot",ChatbotCreateView)
router.register(r"Meditation",MeditationCreateView)
router.register(r"Login",LoginAPI)


urlpatterns = [
    path('admin/',admin.site.urls),
    path('client/', ClientCreateView.as_view(), name='register'),
    path('chatbot/', ChatbotCreateView.as_view(), name='chatbot'),
    path('meditation/',MeditationCreateView.as_view(), name='meditation'),
    path('login/', LoginAPI.as_view(), name='login'),
]
