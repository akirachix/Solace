from django import views
from django.urls import path, include
from rest_framework import routers

from .views import *

router =routers.DefaultRouter()
router.register(r"register",RegisterViewSet)
router.register(r"client",ClientViewSet)
router.register(r"Chatbot",ChatbotViewSet)
router.register(r"Meditation",MeditationViewSet)


urlpatterns = [
    path('', include(router.urls)),
    path('login/',LoginAPI.as_view(), name='login'),
    # path('login/', include,router.urls),

 ]

