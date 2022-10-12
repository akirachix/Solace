from django.db import router
from django.urls import path,include
from rest_framework import routers
from user.models import ChatBot
from.views import ChatBotViewsets, UserViewsets

router=routers.DefaultRouter()
router.register("user",UserViewsets)
router.register("chatbot",ChatBotViewsets)

urlpatterns = [
    path("",include(router.urls))
    

]