from rest_framework import serializers
from django.contrib.auth.models import User
from user.models import Meditation


# User Serializer
class UserSerializer(serializers.ModelSerializer):
    password = serializers.CharField(
        write_only=True,
        required=True,
        style={"input_type": "password", "placeholder": "Password"})
    class Meta:
        model = User
        fields = ('id', 'first_name','last_name', 'email','password')

        
class ChatbotSerializer(serializers.ModelSerializer):
        write_only=True,
        required=True,
        style={"input_type": "user_input", "placeholder": "Response"}

        class Meta:
          model = User
        fields = ('user_input', 'response')  

# Meditation serializer 
class MeditationSerializer(serializers.ModelSerializer):
    class Meta:
        model = Meditation
        fields = ('duration','meditation_type')
      
# Register Serializer
class RegisterSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ('id', 'username','last_name', 'email','password')
        extra_kwargs = {'password': {'write_only': True}}
    def create(self, validated_data):
        user = User.objects.create_user(validated_data['username'],validated_data['email'], validated_data['password'])
        return user
