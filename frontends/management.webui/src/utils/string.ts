export function asString(value: unknown): string {
  if (!value) return '';
  if (value instanceof Object) return value.toString();
  if (Array.isArray(value)) return value.join(', ');
  return (value as object).toString();
}
