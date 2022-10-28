from telnetlib import AUTHENTICATION
from solaceapp import models
from .serializers import*
from django.http import JsonResponse
from rest_framework.parsers import JSONParser
from rest_framework.response import Response
from rest_framework import generics,permissions
from django.contrib.auth.models import User
from django.views.decorators.csrf import csrf_exempt
from knox.models import AuthToken
from rest_framework .permissions import IsAuthenticated


# Create your views here.

@csrf_exempt
def ClientApi(request,id=0):
    if request.method=='GET':
        clients = models.Client.objects.all()
        client_serializer = ClientSerializer(clients,many=True)
        return JsonResponse(client_serializer.data,safe=False)
    elif request.method=='POST':
        client_data = JSONParser().parse(request)
        client_serializer = ClientSerializer(data=client_data)
        if client_serializer.is_valid():
            client_serializer.save()
            return JsonResponse("Added Successfully",safe=False)
        return JsonResponse("Failed to add",safe=False)
    elif request.method=='PUT':
        client_data=JSONParser().parse(request)
        client = models.Client.objects.get(middle_name = client_data['middle_name'])
        client_serializer=ClientSerializer(client,data=client_data)
        if client_serializer.is_valid():
            client_serializer.save()
            return JsonResponse("Updated Successfully",safe=False)
        return JsonResponse("Failed to update",safe=False)
    elif request.method=='DELETE':
        client=models.Client.objects.get(middle_name='middle_name')
        client.delete()
        return JsonResponse("Deleted successfully",safe=False)

class ClientRegisterCreateView(generics.GenericAPIView):
    permission_classes = [IsAuthenticated]
    serializer_class = ClientRegisterSerializer

class ClientCreateView(generics.GenericAPIView):
    # permission_classes = (permissions.AllowAny)

    queryset = models.Client.objects.all()
    serializer_class = ClientSerializer

class ChatbotCreateView(generics.GenericAPIView):
    # permission_classes = (permissions.AllowAny)

    queryset = models.Chatbot.objects.all()
    serializer_class = ChatbotSerializer

class MeditationCreateView(generics.GenericAPIView):
    # permission_classes = (permissions.AllowAny)
    queryset = models.Meditation.objects.all()
    serializer_class = MeditationSerializer


# Register API
class RegisterAPI(generics.GenericAPIView):
    def post(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        client = serializer.save()
        User.objects.create_user(full_name=models.Client.client, password=models.Client.password)
        return Response({
        "student": serializers.StudentSerializer(client, context=self.get_serializer_context()).data,
        # "token": AuthToken.objects.create(student)[1]
        })

class LoginAPI(AuthToken):
    permission_classes = (permissions.AllowAny)
    def post(self, request, ):
        email=request.data['email']
        password=request.data['password']
        user= AUTHENTICATION(request,email=email, password=password)
        print(user)
        token = token.objects.get_or_create(user=user)
        return Response({
            'body': 'login successful',
            "token": token.key
        })

