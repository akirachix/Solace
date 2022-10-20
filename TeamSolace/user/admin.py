from django.contrib import admin
from user.models import  Meditation,User

# Register your models here.
class UserAdmin(admin.ModelAdmin):
    list_display=("first_name","last_name","email","password")
    search_fields=("first_name","last_name","email","password")
admin.site.register(User,UserAdmin)

class MeditationAdmin(admin.ModelAdmin):
    list_display=("duration","meditation_type")
    search_fields=("duration","meditation_type")
admin.site.register(Meditation,MeditationAdmin)





