from rest_framework import serializers
from django.contrib.auth.models import User
from solaceapp import models

# Client Serializer
class ClientSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Client
        fields = ('full_name','email','password','gender','profile_picture')

class ClientRegisterSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Client
        fields = ('full_name','email','password')
        extra_kwargs = {'password': {'write_only': True}}

    def create(self, validated_data):
         user = models.Client.objects.create(validated_data['email'], validated_data['password'])
         return user       

# Chatbot serializer
class ChatbotSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Chatbot
        fields = ('user_name','user_input', 'response')  

# Meditation serializer 
class MeditationSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Meditation
        fields = ('meditation_type','count_down','music')

# Login serializer
class LoginSerializer(serializers.ModelSerializer):
        class Meta:
          model = models.Login
          fields = ('email', 'password')  

