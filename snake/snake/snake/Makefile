CXX:=g++
LD:=g++

MODE?=Debug

CXXFLAGS := -Wall -Wextra

ifeq ($(MODE),Debug)
CXXFLAGS += -g
else
CXXFLAGS += -O2 -march=native -flto
LDFLAGS  := -flto
MODE     := Release
endif

CXXFLAGS_COMMON += $(shell pkg-config --cflags sdl)

CPPFLAGS := -I./
LIBS     := -lstdc++ $(shell pkg-config --libs SDL_image)

OBJ_DIR      := obj/$(MODE)
BIN_DIR      := bin/$(MODE)

SOURCE_FILES := $(wildcard *.cpp)
OBJ_FILES    := $(SOURCE_FILES:%.cpp=$(OBJ_DIR)/%.o)

.PHONY: all
all: snake

$(OBJ_DIR)/%.o : %.cpp
$(OBJ_DIR)/%.o : %.cpp | $(OBJ_DIR)
	$(CXX) $(CXXFLAGS) -c $< -o $@

.PHONY: snake
snake: $(OBJ_FILES) | $(BIN_DIR)
	$(LD) $(LDFLAGS) -o $(BIN_DIR)/$@ $^ $(LIBS)
	

$(OBJ_DIR):
	@echo "create obj dir"
	mkdir -p $@
	
$(BIN_DIR):
	mkdir -p $@
	
.PHONY:	
clean:
	-rm $(OBJ_DIR)/*.o
	-rm $(BIN_DIR)/*