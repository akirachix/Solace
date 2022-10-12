from rest_framework import viewsets
from user.models import ChatBot, User
from .serializer import ChatBotSerializer, UserSerializer

class UserViewsets(viewsets.ModelViewSet):

    queryset=User.objects.all()
    serializer_class=UserSerializer


class ChatBotViewsets(viewsets.ModelViewSet):

    queryset=ChatBot.objects.all()
    serializer_class=ChatBotSerializer
    