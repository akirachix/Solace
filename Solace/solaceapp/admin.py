from django.contrib import admin

from .models import *

# Register your models here.
class ClientAdmin(admin.ModelAdmin):
    list_display=("full_name","email","password","gender","profile_picture")
    search_fields=("full_name","email","password","gender","profile_picture")
admin.site.register(Client,ClientAdmin)

class MeditationAdmin(admin.ModelAdmin):
    list_display=("meditation_type","count_down","music")
    search_fields=("meditation_type","count_down","music")
admin.site.register(Meditation,MeditationAdmin)

class ChatbotAdmin(admin.ModelAdmin):
    list_display=("user_name","user_input","response")
    search_fields=("user_name","user_input","response")
admin.site.register(Chatbot,ChatbotAdmin)

class CountdownTimerAdmin(admin.ModelAdmin):
    list_display = ("start_time","stop_time")
    search_fields = ("start_time","stop_time")
admin.site.register(CountdownTimer,CountdownTimerAdmin)

class MusicAdmin(admin.ModelAdmin):
    list_display=("music",)
    search_fields=("music",)
admin.site.register(Music,MusicAdmin)
