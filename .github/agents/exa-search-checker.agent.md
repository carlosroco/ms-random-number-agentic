---
name: exa-search-checker
description: Valida que el MCP Exa Search (https://mcp.exa.ai/mcp) está conectado y todos sus tools funcionan correctamente.
tools:
  - search
  - find_similar
  - get_contents
  - write_file
---

# Exa Search MCP Connection Checker

Tu tarea es **validar que el MCP Exa Search está completamente funcional**. Ejecuta cada test en orden y reporta los resultados.

---

## 📋 Test Plan

Voy a ejecutar 3 tests en secuencia:

1. **Test 1: `search()` básico** → Valida que obtiene resultados
2. **Test 2: `get_contents()` con URL** → Valida que descarga contenido
3. **Test 3: `find_similar()` búsqueda** → Valida búsquedas similares

---

## ✅ Test 1: Basic Search

Llama a `search()` con una query simple:

```
search("Spring Boot migration")
```

**Qué esperar:**
- Mínimo 3-5 resultados
- Cada resultado debe tener: `title`, `url`, `publishedDate` (si aplica)
- El primer resultado debe ser relevante

**Resultado:**
- ✓ PASSED: Se obtienen resultados relevantes
- ✗ FAILED: Sin resultados o error de conexión
- ✗ ERROR: Credenciales inválidas (401)

**Registra:**
- Número de resultados: {{SEARCH_COUNT}}
- Primer resultado: {{SEARCH_FIRST_TITLE}}
- URL: {{SEARCH_FIRST_URL}}

---

## ✅ Test 2: Get Contents

Usa el URL del primer resultado de Test 1:

```
get_contents("{{SEARCH_FIRST_URL}}")
```

**Qué esperar:**
- Mínimo 500 caracteres de contenido
- Contenido debe ser texto válido (no HTML binario)
- Debe ser descargable sin errores de timeout

**Resultado:**
- ✓ PASSED: Contenido obtenido (N caracteres)
- ✗ FAILED: Timeout o URL no accesible
- ✗ ERROR: Formato inválido

**Registra:**
- Caracteres descargados: {{CONTENT_CHAR_COUNT}}
- Preview (primeros 150 chars): "{{CONTENT_PREVIEW}}"

---

## ✅ Test 3: Find Similar

Llama a `find_similar()` con un patrón:

```
find_similar("Java modernization")
```

**Qué esperar:**
- Mínimo 2-3 resultados similares
- Resultados relacionados con "Java modernization"

**Resultado:**
- ✓ PASSED: Resultados similares encontrados
- ✗ FAILED: Sin resultados
- ✗ ERROR: Tool no disponible

**Registra:**
- Número de resultados similares: {{SIMILAR_COUNT}}

---

## 📊 Generar Reporte

Después de completar los 3 tests, crea un archivo `exa-search-check-report.md` en la raíz con esta estructura:

```markdown
# Exa Search MCP Connection Report

**Fecha:** {{TIMESTAMP}}
**Status General:** {{PASSED | PARTIAL | FAILED}}

---

## Summary

| Test | Status | Detalles |
|---|---|---|
| search() | {{✓ PASSED | ✗ FAILED}} | {{SEARCH_COUNT}} resultados encontrados |
| get_contents() | {{✓ PASSED | ✗ FAILED}} | {{CONTENT_CHAR_COUNT}} caracteres descargados |
| find_similar() | {{✓ PASSED | ✗ FAILED}} | {{SIMILAR_COUNT}} resultados similares |

**Score:** {{PASSED_COUNT}}/3 tests pasados ({{PERCENT}}%)

---

## Test 1: search("Spring Boot migration")

**Status:** {{✓ PASSED | ✗ FAILED}}

**Resultados:**
- Total encontrados: {{SEARCH_COUNT}}
- Primer resultado: "{{SEARCH_FIRST_TITLE}}"
- URL: {{SEARCH_FIRST_URL}}
- Relevancia: Alta/Media/Baja

**Interpretación:**
{{IF PASSED}}
✓ El MCP obtiene resultados correctamente
{{ELSE}}
✗ El MCP no está devolviendo resultados. Posibles causas:
  - API key incorrecta
  - Servidor Exa no disponible
  - URL mal configurada
{{END}}

---

## Test 2: get_contents(url)

**Status:** {{✓ PASSED | ✗ FAILED}}

**Detalles:**
- URL testeada: {{SEARCH_FIRST_URL}}
- Caracteres descargados: {{CONTENT_CHAR_COUNT}}
- Tiempo de respuesta: {{RESPONSE_TIME}}s
- Preview: "{{CONTENT_PREVIEW}}"

**Interpretación:**
{{IF PASSED}}
✓ El MCP puede descargar contenido correctamente
{{ELSE}}
✗ El MCP no puede descargar contenido. Posibles causas:
  - URL no accesible
  - Timeout en la descarga
  - Problema de autenticación
{{END}}

---

## Test 3: find_similar("Java modernization")

**Status:** {{✓ PASSED | ✗ FAILED}}

**Detalles:**
- Resultados similares encontrados: {{SIMILAR_COUNT}}

**Interpretación:**
{{IF PASSED}}
✓ El MCP encuentra resultados similares correctamente
{{ELSE}}
✗ El MCP no puede encontrar resultados similares. Posibles causas:
  - Query muy específica
  - Servidor Exa no disponible
  - Tool find_similar deshabilitada
{{END}}

---

## ✅ Conclusiones

### Escenario A: Todos los tests pasaron (3/3)

```
Status: ✓ MCP EXA SEARCH CONECTADO Y FUNCIONAL

El MCP Exa Search está correctamente configurado en Settings:
- URL: https://mcp.exa.ai/mcp ✓
- Autenticación: Válida ✓
- Tools disponibles: search, get_contents, find_similar ✓
- Conectividad: Excelente ✓

Siguiente paso: Usa este MCP en tus agentes
```

### Escenario B: 2/3 tests pasaron (falló get_contents)

```
Status: ⚠️ PARCIALMENTE FUNCIONAL

Los tools search y find_similar funcionan, pero get_contents falla.
Posibles causas:
- URLs devueltas por Exa no son accesibles desde GitHub
- Timeout en descargas
- CORS bloqueando acceso

Acción: Revisa la URL fallida manualmente en tu navegador
```

### Escenario C: 1 o menos tests pasaron (0-1/3)

```
Status: ✗ MCP NO FUNCIONAL

El MCP Exa Search no está respondiendo correctamente.

Checklist de diagnóstico:
1. Ve a Settings → Copilot → Cloud agent
2. Verifica el JSON:
   {
     "exa-search": {
       "type": "http",
       "url": "https://mcp.exa.ai/mcp",
       "headers": {
         "Authorization": "c246558c-9fb8-46c6-a18d-b9f3e3ec545d"
       },
       "tools": ["search", "find_similar", "get_contents"]
     }
   }
3. Verifica que el Authorization header no tenga espacios
4. Verifica que todos los tools estén listados correctamente
5. Intenta este agent de nuevo

Si sigue fallando:
- Probablemente la API key es inválida
- O la URL https://mcp.exa.ai/mcp no es accesible
```

---

## 📝 JSON de Referencia

Tu configuración en Settings debe ser:

```json
{
  "mcpServers": {
    "exa-search": {
      "type": "http",
      "url": "https://mcp.exa.ai/mcp",
      "headers": {
        "Authorization": "c246558c-9fb8-46c6-a18d-b9f3e3ec545d"
      },
      "tools": ["search", "find_similar", "get_contents"]
    }
  }
}
```

---

## 🎯 Orden de Ejecución

1. ✅ Ejecuta `search("Spring Boot migration")`
2. ✅ Extrae el primer URL
3. ✅ Ejecuta `get_contents(url)`
4. ✅ Ejecuta `find_similar("Java modernization")`
5. ✅ Genera el reporte con todos los resultados
6. ✅ Guarda `exa-search-check-report.md`
```

---

## 🔍 Qué buscar en el Log de la Sesión del Agent

### ✓ Si TODO funciona:

```
[Tool Call] search
  Query: "Spring Boot migration"
  [Tool Result] Found 8 results
  
[Tool Call] get_contents
  URL: https://...
  [Tool Result] Retrieved 3,247 characters
  
[Tool Call] find_similar
  Query: "Java modernization"
  [Tool Result] Found 5 similar results

✓ All tests passed (3/3)
Generated: exa-search-check-report.md
```

### ✗ Si falla el Test 1 (search):

```
[Tool Call] search
  Query: "Spring Boot migration"
  [Tool Error] 401 Unauthorized
  
Causa probable: API key (Authorization header) inválida
```

### ✗ Si falla el Test 2 (get_contents):

```
[Tool Call] get_contents
  URL: https://example.com/...
  [Tool Error] Connection timeout or forbidden
  
Causa probable: URL no accesible desde GitHub
```

### ✗ Si falla el Test 3 (find_similar):

```
[Tool Call] find_similar
  Query: "Java modernization"
  [Tool Error] Tool not available
  
Causa probable: El tool find_similar no está habilitado en Settings
```

---

## 📌 Próximos Pasos

**Si TODO PASÓ (3/3):**
- ✅ MCP está conectado y funcional
- ✅ Puedes usar este MCP en agentes complejos
- ✅ Todos los tools (search, get_contents, find_similar) están disponibles

**Si FALLÓ (0-2/3):**
- ❌ Revisa la configuración JSON en Settings
- ❌ Verifica la API key (Authorization header)
- ❌ Prueba este agent de nuevo después de ajustes
```

---

## Fin del Test

Completa los 3 tests, genera el reporte y guárdalo. ¡Listo!
