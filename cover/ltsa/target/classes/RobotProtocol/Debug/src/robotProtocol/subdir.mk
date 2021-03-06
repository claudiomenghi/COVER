################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/robotProtocol/Message.cpp \
../src/robotProtocol/MessageManager.cpp \
../src/robotProtocol/MessageManager_test.cpp \
../src/robotProtocol/MessageReceiver.cpp \
../src/robotProtocol/MessageReceiver_test.cpp \
../src/robotProtocol/MessageSender.cpp \
../src/robotProtocol/MessageSender_test.cpp \
../src/robotProtocol/Message_test.cpp \
../src/robotProtocol/TestSenderReceiver.cpp 

OBJS += \
./src/robotProtocol/Message.o \
./src/robotProtocol/MessageManager.o \
./src/robotProtocol/MessageManager_test.o \
./src/robotProtocol/MessageReceiver.o \
./src/robotProtocol/MessageReceiver_test.o \
./src/robotProtocol/MessageSender.o \
./src/robotProtocol/MessageSender_test.o \
./src/robotProtocol/Message_test.o \
./src/robotProtocol/TestSenderReceiver.o 

CPP_DEPS += \
./src/robotProtocol/Message.d \
./src/robotProtocol/MessageManager.d \
./src/robotProtocol/MessageManager_test.d \
./src/robotProtocol/MessageReceiver.d \
./src/robotProtocol/MessageReceiver_test.d \
./src/robotProtocol/MessageSender.d \
./src/robotProtocol/MessageSender_test.d \
./src/robotProtocol/Message_test.d \
./src/robotProtocol/TestSenderReceiver.d 


# Each subdirectory must supply rules for building sources it contributes
src/robotProtocol/%.o: ../src/robotProtocol/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: AVR C++ Compiler'
	avr-g++ -Wall -g2 -gstabs -O0 -fpack-struct -fshort-enums -funsigned-char -funsigned-bitfields -fno-exceptions -mmcu=atmega16 -DF_CPU=1000000UL -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -c -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


