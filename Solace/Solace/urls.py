"""Solace URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""

from django.contrib import admin
from django.urls import path,include
from solaceApi.views import *

urlpatterns = [
    path('admin/', admin.site.urls),
    path('client/', ClientCreateView.as_view(), name='register'),
    path('chatbot/', ChatbotCreateView.as_view(), name='chatbot'),
    path('meditation/',MeditationCreateView.as_view(), name='meditation'),
    # path('login/', LoginAPI.as_view(), name='login'),
]
