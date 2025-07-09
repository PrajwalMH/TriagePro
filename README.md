# 🏥 TriagePro

A **full-stack AI-powered patient triage & appointment booking system** built with:

- 🧩 **Spring Boot + MySQL** for backend APIs & database
- ⚡ **Next.js + Tailwind CSS** for modern responsive frontend
- 🤖 **Python Flask microservice** for AI-based triage prediction

---

## 🚀 Features

✅ **Smart Symptom Triage**  
- Predicts department & urgency level (LOW / MEDIUM / HIGH) from user input using AI.

✅ **Interactive Dashboard**  
- Shows all triage logs in a table.
- Live filters and pie chart visualization.

✅ **Appointment Booking**  
- Book slots with a doctor based on triage outcome.

✅ **Modern UI**  
- Animated splash screen, smooth transitions, active nav links.

---

## 🏗️ Tech Stack

| Layer    | Technologies                       |
|----------|------------------------------------|
| Frontend | Next.js, Tailwind CSS, Chart.js    |
| Backend  | Spring Boot, MySQL                 |
| AI       | Python Flask microservice          |

---

## ⚙️ How to Run This Project

### 📦 Clone the repository

```bash
git clone https://github.com/yourusername/TriagePro.git
cd TriagePro
```

---

### 🚀 Start the Spring Boot backend

✅ Make sure your **MySQL server is running** and database `triagepro_db` exists.

```bash
cd TriagePro-Backend
./mvnw spring-boot:run
```

or on Windows:

```bash
mvnw.cmd spring-boot:run
```

📌 Backend runs on: **http://localhost:8080**

---

### 🤖 Start the AI microservice (Flask)

```bash
cd TriagePro-AI
python app.py
```

📌 AI microservice runs on: **http://localhost:5000**

---

### 🌐 Start the Next.js frontend

```bash
cd TriagePro-Frontend
npm install
npm run dev
```

📌 Frontend runs on: **http://localhost:3000**

---

## 📝 Example Inputs

| Symptom Input                                      | Predicted Output                          |
|----------------------------------------------------|------------------------------------------|
| `I have chest pain and shortness of breath`        | 🔥 HIGH — Cardiology                     |
| `I have fever and a little cough`                  | 🟡 MEDIUM — General Medicine             |
| `Just feeling a bit tired with mild headache`      | 🟢 LOW — General Medicine                |
| `Sudden onset of chest tightness`                  | 🔥 HIGH — Cardiology                     |

---

## 📸 Screenshots Gallery

<p align="center">
  <img src="./TriagePro-Frontend/screenshots/dashboard.png" width="400"/>
  <img src="./TriagePro-Frontend/screenshots/symptoms.png" width="400"/>
  <img src="./TriagePro-Frontend/screenshots/booking.png" width="400"/>
</p>

✅ Add as many images as you want.  
Ensure they are all stored under `TriagePro-Frontend/screenshots/`.

---

## 📝 Future Enhancements

- 🩺 Use a real trained ML model with TensorFlow / Scikit-Learn.
- 📅 Integrate a calendar view for appointments.
- 🔔 Email / SMS notifications to patients.
- 🔒 Add authentication for patients & doctors.

---

## 👨‍💻 Author

**Prajwal Mrithyunjay Hulamani**  
- [GitHub](https://github.com/yourusername)  
- [LinkedIn](https://linkedin.com/in/yourprofile)
