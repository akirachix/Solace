from rest_framework import generics, permissions
from rest_framework.response import Response
from knox.models import AuthToken
from .serializer import ChatbotSerializer, UserSerializer,RegisterSerializer,MeditationSerializer
from knox.views import LoginView as KnoxLoginView

# Register API
class RegisterAPI(generics.GenericAPIView):
    serializer_class = RegisterSerializer
    def post(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.save()
        return Response({
        "user": UserSerializer(user, context=self.get_serializer_context()).data,
        "token": AuthToken.objects.create(user)[1]
        })

# Login API
class LoginAPI(KnoxLoginView):
    permission_classes = (permissions.AllowAny,)
    def post(self, request, format=None):
        serializer = AuthTokenSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.validated_data['user']
        login(request, user)
        return super(LoginAPI, self).post(request, format=None)
        

# ChatbotAPI
class ChatbotAPI(generics.GenericAPIView):
    permission_classes = ChatbotSerializer
    def post(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.save()
        return Response({
        "user": ChatbotSerializer(user, context=self.get_serializer_context()).data,
        })

# meditation API
class MeditationAPI(generics.GenericAPIView):
    permission_classes = MeditationSerializer
    def post(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.save()
        return Response({
        "user": MeditationSerializer(user, context=self.get_serializer_context()).data,
        })

