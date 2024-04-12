import React, { useState } from 'react';

const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    // Aquí puedes agregar la lógica para autenticar al usuario con el servidor
    // Por simplicidad, solo mostraré un mensaje de error si el usuario y la contraseña están vacíos
    if (!username || !password) {
      setError('Por favor, introduce un nombre de usuario y una contraseña');
      return;
    }
    // Aquí puedes hacer la llamada a tu backend para autenticar al usuario
    // Si tienes éxito, puedes redirigir al usuario a la página principal o hacer cualquier otra acción necesaria
    console.log('Usuario autenticado');
  };

  return (
    <div>
      <h2>Iniciar sesión</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <form onSubmit={handleLogin}>
        <div>
          <label>Nombre de usuario:</label>
          <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
        </div>
        <div>
          <label>Contraseña:</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </div>
        <button type="submit">Iniciar sesión</button>
      </form>
    </div>
  );
};

export default LoginForm;
