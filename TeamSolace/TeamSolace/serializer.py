
from rest_framework import serializers
from django.contrib.auth.models import User
from user import models

# User Serializer
class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['first_name', 'last_name', 'email','password']

class RegisterSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.User
        fields = ('first_name', 'last_name', 'email', 'password')
        extra_kwargs = {'password': {'write_only': True}}

password = serializers.CharField(write_only=True, required=True)
password2 = serializers.CharField(write_only=True, required=True)

class Meta:
    model = User
    fields = ('password', 'first_name', 'last_name',)
    extra_kwargs = {
      'first_name': {'required': True},
      'last_name': {'required': True},
      'password':  {'required': True}
    }
def validate(self, attrs):
    if attrs['password'] != attrs['password2']:
      raise serializer.ValidationError(
        {"password": "Password fields didn't match."})
    return attrs

def create(self, validated_data):
    user = User.objects.create(
      username=validated_data['username'],
      first_name=validated_data['first_name'],
      last_name=validated_data['last_name']
    )
    user.set_password(validated_data['password'])
    user.save()
    return user
class LoginSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Login
        fields = ('user_name', 'password',)



