import pandas as pd


def get_data():
    return pd.read_csv('../dataset.csv', sep=',')


df = get_data()


def get_total_population():
    return df.count().Gender


def get_total_male():
    return df[df['Gender'] == 'Male'].count().Gender


def get_total_female():
    return df[df['Gender'] == 'Female'].count().Gender


def get_married_male():
    return df[(df['Gender'] == 'Male') & (df['Married'] == 'Yes')].count().Gender


def get_married_female():
    return df[(df['Gender'] == 'Female') & (df['Married'] == 'Yes')].count().Gender


def get_graduate_man():
    return df[(df['Gender'] == 'Male') & (df['Education'] == 'Graduate')].count().Education


def get_graduate_women():
    return df[(df['Gender'] == 'Female') & (df['Education'] == 'Graduate')].count().Education


def get_married_graduate():
    return df[(df['Married'] == 'Yes') & (df['Education'] == 'Graduate')].count().Education


def get_married_not_graduate():
    return df[(df['Married'] == 'Yes') & (df['Education'] == 'Not Graduate')].count().Education


def get_urban_married():
    return df[(df['Married'] == 'Yes') & (df['Property_Area'] == "Urban")].count().Property_Area


def get_rural_married():
    return df[(df['Married'] == 'Yes') & (df['Property_Area'] == "Rural")].count().Property_Area


def get_semiurban_married():
    return df[(df['Married'] == 'Yes') & (df['Property_Area'] == "Semiurban")].count().Property_Area


def get_urban():
    return df[(df['Property_Area'] == 'Urban')].count().Property_Area


def get_rural():
    return df[(df['Property_Area'] == 'Rural')].count().Property_Area


def get_semiurban():
    return df[(df['Property_Area'] == 'Semiurban')].count().Property_Area


def get_percent_married_urban():
    return round(get_urban_married() * 100 / get_total_population(), 1)


def get_percent_married_rural():
    return round(get_rural_married() * 100 / get_total_population(), 1)


def get_percent_married_semiurban():
    return round(get_semiurban_married() * 100 / get_total_population(), 1)
