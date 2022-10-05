from django.db import models

# Create your models here.
class User(models.Model):
    first_name = models.CharField(max_length=30,null=True)
    last_name = models.CharField(max_length=30,null=True)
    email = models.EmailField()
    password=models.CharField(max_length=15,null=True)
    profile_picture = models.ImageField(default='default.jpg', upload_to='profile_pics')

class Count_down(models.Model):
    timer=models.TimeField()   
