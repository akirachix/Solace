from django.db import models

# Create your models here.
class User(models.Model):
    user_name = models.CharField(max_length=100, null=True)
    first_name = models.CharField(max_length=30,null=True)
    last_name = models.CharField(max_length=30,null=True)
    email = models.EmailField()
    password=models.CharField(max_length=15,null=True)
    profile_picture = models.ImageField(default='default.jpg', upload_to='profile_pics')

class Meditation(models.Model):
    duration=models.TimeField()
    meditation_choices= (
        ('mindfullness','mindfullness'),
        ('breathing','breathing'),
        ('mantra','mantra'),
        ('walking','walking'),
    )
    meditation_type=models.CharField(max_length=50, choices=meditation_choices,null=True)

class Login(models.Model):
    user_name=models.CharField(max_length=30)
    password=models.CharField(max_length=30)
    
class Register(models.Model):
    first_name = models.CharField(max_length=20)
    last_name = models.CharField(max_length=240)
    user_name=models.CharField(max_length=30,null=True)
    GENDER_CHOICES=(
       ("M", "Male"),
       ("F", "Female"),
       ("N","Other"),
   )
    gender= models.CharField(max_length=1,choices=GENDER_CHOICES,null=True)
   







