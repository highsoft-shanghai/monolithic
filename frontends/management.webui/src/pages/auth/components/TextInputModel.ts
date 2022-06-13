export interface TextInputModel {
  readonly changeValue: (value: string) => void;
  readonly value: string;
  readonly maxLength: number | undefined;
  readonly rules: ((value: string) => true | string)[];
}
