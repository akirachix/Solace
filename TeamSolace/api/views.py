import email
from rest_framework.authtoken.models import Token
from user import models
from .serializer import*
# ClientRegisterSerializer, ClientSerializer,DiscoveryListSerializer,ChatbotSerializer
from django.http import JsonResponse
from rest_framework.parsers import JSONParser
from rest_framework.response import Response
from rest_framework import generics, permissions
from django.contrib.auth import authenticate
from django.contrib.auth.models import User
from rest_framework.authtoken.views import ObtainAuthToken
from django.views.decorators.csrf import csrf_exempt
from knox.models import AuthToken
from django.contrib.auth import login



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

class ClientRegisterViewSet(generics.GenericAPIView):
    queryset =  models.Client.objects.all()
    serializer_class = ClientRegisterSerializer

    def post(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        client = serializer.save()
        User.objects.create_user(email=client.email , password=client.password)
        return Response({
        "client": ClientSerializer(client, context=self.get_serializer_context()).data,
        "token": AuthToken.objects.create(client)[1]
        })

class ChatbotViewSets(generics.GenericAPIView):
    queryset = models.Chatbot.objects.all()
    serializer_class = ChatbotSerializer


class DiscoveryListViewSets(generics.GenericAPIView):
    queryset = models.DiscoveryList.objects.all()
    serializer_class = DiscoveryListSerializer


class LoginAPI(ObtainAuthToken):
    permission_classes = (permissions.AllowAny,)
    def post(self, request, ):
        email=request.data['email']
        password=request.data['password']
        user= authenticate(request,email=email, password=password)
        print(user)
        token = token.objects.get_or_create(user=user)
        return Response({
            'body': 'login successful',
            "token": token.key
        })

