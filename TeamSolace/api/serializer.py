from dataclasses import fields
from pyexpat import model
from rest_framework import serializers
from user.models import ChatBot, User

class UserSerializer(serializers.ModelSerializer):

    class Meta:
        model=User
        fields=('first_name','last_name','email')

class ChatBotSerializer(serializers.ModelSerializer):
     class Meta:
        model=ChatBot
        fields=('tag','message')
