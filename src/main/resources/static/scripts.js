document.addEventListener('DOMContentLoaded', () => {
    const studentForm = document.getElementById('studentForm');

    studentForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(event.target);
        const student = Object.fromEntries(formData.entries());

        // Validation supplémentaire
        if (!validateForm(student)) return;

        // Envoi des données
        sendStudentData(student);
    });

    function validateForm(student) {
        const phoneRegex = /^[0-9]{10}$/;

        if (!phoneRegex.test(student.phone)) {
            alert('Numéro de téléphone invalide');
            return false;
        }

        if (student.age < 16 || student.age > 99) {
            alert('Âge non valide');
            return false;
        }

        return true;
    }

    function sendStudentData(student) {
        fetch('/api/students', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(student)
        })
        .then(response => {
            if (!response.ok) throw new Error('Erreur réseau');
            return response.json();
        })
        .then(data => {
            Swal.fire({
                icon: 'success',
                title: 'Inscription réussie!',
                text: 'Votre profil a été enregistré avec succès.'
            });
            studentForm.reset();
        })
        .catch(error => {
            Swal.fire({
                icon: 'error',
                title: 'Erreur',
                text: 'Un problème est survenu lors de l\'inscription.'
            });
        });
    }
});