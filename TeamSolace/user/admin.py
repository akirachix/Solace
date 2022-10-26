from django.contrib import admin
from user.models import  Chatbot, DiscoveryList,Client,CountdownTimer,Music

# Register your models here.
class ClientAdmin(admin.ModelAdmin):
    list_display=("first_name","last_name","email","password","gender","profile_picture")
    search_fields=("first_name","last_name","email","password","gender","profile_picture")
admin.site.register(Client,ClientAdmin)

class DiscoveryListAdmin(admin.ModelAdmin):
    list_display=("meditation_type",)
    search_fields=("meditation_type",)
admin.site.register(DiscoveryList,DiscoveryListAdmin)

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



