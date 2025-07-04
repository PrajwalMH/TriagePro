from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    symptoms = data.get('symptoms', '').lower()
    
    if 'chest' in symptoms or 'pain' in symptoms:
        return jsonify({
            "department": "Cardiology",
            "triage_level": "HIGH"
        })
    elif 'fever' in symptoms or 'cough' in symptoms:
        return jsonify({
            "department": "General Medicine",
            "triage_level": "MEDIUM"
        })
    else:
        return jsonify({
            "department": "General Medicine",
            "triage_level": "LOW"
        })

if __name__ == '__main__':
    app.run(port=5000)
