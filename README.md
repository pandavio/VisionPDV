# 🧠 PDV Vision - AI Visual Assistant for the Visually Impaired App

**PDV Vision** is an AI-powered mobile app designed to assist visually impaired individuals with real-time object recognition, speech feedback, and smart navigation support. It leverages YOLOv5 for object detection and OpenAI GPT-4o for scene understanding and natural language generation.

## 🌟 Features

- 📷 **Smart Image Recognition**  
  Detects objects using YOLOv5 and generates natural language descriptions with GPT-4o

- 🗣️ **Speech Output**  
  Automatically narrates the scene in English or Chinese based on user input

- 📍 **GPS Support**  
  Retrieves current address using Google Maps API in outdoor mode

- 🧭 **Three Interaction Modes**  To Be Enhance...
  - **Outdoor Mode**: Prioritizes crosswalks, traffic lights, obstacles, etc.  
  - **Indoor Mode**: Detects restrooms, entrances, exits, and main doors  
  - **Normal Mode**: Provides general descriptions in a neutral style

## 🔧 Tech Stack

- **Frontend**: Basic4Android (B4A) for Android app
- **Backend**: Flask + YOLOv5 + OpenAI GPT-4o API
- **Deployment**: Local or cloud server (e.g., Render)

## 🚀 Getting Started

### 1. Backend Setup

```bash
git clone https://github.com/pandavio/vision-server.git
cd pdv-vision-server
pip install -r requirements.txt
python app.py
```

### 2. Android App Setup

- Open the project in B4A (`PDVVision.b4a`)
- Configure your API keys in `Files/config.txt`:
  ```
  GOOGLE_MAPS_KEY=maps_key
  SERVER_URL=https://server.com/analyze
  SERVER_PING_URL=https://server.com/ping
  ```
- Build and install the app on your Android phone

## 🔑 Required API Keys

To run this app, you must provide:

- `GOOGLE_MAPS_KEY`: For retrieving geolocation addresses
- `SERVER_URL` and `SERVER_PING_URL`: To send image data and wake the server


## 📂 Project Structure

```
PDVVision/
├── B4A/              # Android app source (Basic4Android)
├── server/           # Flask server for image processing
├── README.md
├── requirements.txt

```

## 📜 License

This project is released under the MIT License.

# 🧠 PDV Vision - AI视觉导盲助手 App

**PDV Vision** 是一款专为视障人士设计的 AI 移动辅助应用，通过图像识别、语音播报与智能导航模式，实时描述环境信息。系统采用 YOLOv5 进行目标检测，并结合 OpenAI GPT-4o 实现自然语言场景理解与描述生成。

## 🌟 功能亮点

- 📷 **智能图像识别**  
  使用 YOLOv5 检测画面中的目标，结合 GPT-4o 生成自然语言描述

- 🗣️ **语音播报反馈**  
  根据用户输入自动使用中/英文语音播报场景内容

- 📍 **GPS 地址定位**  
  户外模式下通过 Google Maps API 获取当前位置的中文地址

- 🧭 **三种导航模式**  
  - **户外模式**：优先识别斑马线、红绿灯、障碍物等关键元素  
  - **室内模式**：识别厕所、入口、出口、大门等设施  
  - **普通模式**：提供一般性中立风格描述

## 🔧 技术架构

- **前端**：Basic4Android (B4A) 编写的 Android 应用
- **后端**：Flask + YOLOv5 + OpenAI GPT-4o API
- **部署方式**：支持本地部署或 Render 等云服务

## 🚀 快速开始

### 1. 后端部署

```bash
git clone https://github.com/pandavio/vision-server.git
cd pdv-vision-server
pip install -r requirements.txt
python app.py
```

### 2. Android 应用部署

- 使用 B4A 打开项目（PDVVision.b4a）
- 在 `Files/config.txt` 中配置以下密钥：
  ```
  GOOGLE_MAPS_KEY=API密钥
  SERVER_URL=https://服务器/analyze
  SERVER_PING_URL=https://服务器/ping
  ```
- 编译并安装至 Android 手机

## 🔑 所需 API 密钥

运行本应用需要以下密钥支持：

- `GOOGLE_MAPS_KEY`：用于通过坐标获取地址信息
- `SERVER_URL` 与 `SERVER_PING_URL`：用于提交图像与唤醒服务器

## 📂 项目结构

```
PDVVision/
├── B4A/              # Android 客户端源码（B4A）
├── server/           # 图像处理后端 Flask 服务
├── README.md
├── requirements.txt

```

## 📜 开源协议

本项目遵循 MIT 开源协议发布。
