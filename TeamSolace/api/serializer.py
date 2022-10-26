from rest_framework import serializers
from django.contrib.auth.models import User
from user import models

# User Serializer
class ClientSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Client
        fields = ('first_name','last_name','email','password','gender','profile_picture')

class ClientRegisterSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Client
        fields = ('first_name','last_name','email','password')
        extra_kwargs = {'password': {'write_only': True}}

    def create(self, validated_data):
         user = models.Client.objects.create(validated_data['email'], validated_data['password'])
         return user       

# Chatbot serializer
class ChatbotSerializer(serializers.ModelSerializer):
        class Meta:
          model = models.Chatbot
          fields = ('user_input', 'response')  

# Meditation serializer 
class DiscoveryListSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.DiscoveryList
        fields = ('meditation_type',)

# Login serializer
class LoginSerializer(serializers.ModelSerializer):
        class Meta:
          model = models.Login
          fields = ('email', 'password')  
      