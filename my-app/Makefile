NAME = my-app

CC = java
FLAGS = -cp

TARGET_DIR = target
TARGET = my-app-1.0-SNAPSHOT.jar

MAIN = com.gbertet.app.App

all : $(NAME)

$(NAME) :
	@echo "Building maven package..."
	mvn package

run : re
	@echo "Running jar file..."
	$(CC) $(FLAGS) $(TARGET_DIR)/$(TARGET) $(MAIN)

clean :
	rm -rf $(TARGET_DIR)

re : clean all