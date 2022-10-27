from rest_framework import serializers
from django.contrib.auth.models import User
from solaceapp import models


# User Serializer
class ClientSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Client
        fields = ('first_name','last_name','email','password','gender','profile_picture')

        
class ChatbotSerializer(serializers.ModelSerializer):
        class Meta:
          model = models.Chatbot
          fields = ('user_input', 'response')  

# Meditation serializer 
class MeditationSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Meditation
        fields = ('meditation_type','count_down',"music")

# Login serializer
class LoginSerializer(serializers.ModelSerializer):
        class Meta:
          model = models.Login
          fields = ('email', 'password') 