#import "MaterialDatetimepickerView.h"

#import <react/renderer/components/RNMaterialDatetimepickerViewSpec/ComponentDescriptors.h>
#import <react/renderer/components/RNMaterialDatetimepickerViewSpec/EventEmitters.h>
#import <react/renderer/components/RNMaterialDatetimepickerViewSpec/Props.h>
#import <react/renderer/components/RNMaterialDatetimepickerViewSpec/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

using namespace facebook::react;

@interface MaterialDatetimepickerView () <RCTMaterialDatetimepickerViewViewProtocol>

@end

@implementation MaterialDatetimepickerView {
    UIView * _view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<MaterialDatetimepickerViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const MaterialDatetimepickerViewProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];

    self.contentView = _view;
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<MaterialDatetimepickerViewProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<MaterialDatetimepickerViewProps const>(props);

    if (oldViewProps.color != newViewProps.color) {
        NSString * colorToConvert = [[NSString alloc] initWithUTF8String: newViewProps.color.c_str()];
        [_view setBackgroundColor:[self hexStringToColor:colorToConvert]];
    }

    [super updateProps:props oldProps:oldProps];
}

Class<RCTComponentViewProtocol> MaterialDatetimepickerViewCls(void)
{
    return MaterialDatetimepickerView.class;
}

- hexStringToColor:(NSString *)stringToConvert
{
    NSString *noHashString = [stringToConvert stringByReplacingOccurrencesOfString:@"#" withString:@""];
    NSScanner *stringScanner = [NSScanner scannerWithString:noHashString];
    
    unsigned hex;
    if (![stringScanner scanHexInt:&hex]) return nil;
    int r = (hex >> 16) & 0xFF;
    int g = (hex >> 8) & 0xFF;
    int b = (hex) & 0xFF;
    
    return [UIColor colorWithRed:r / 255.0f green:g / 255.0f blue:b / 255.0f alpha:1.0f];
}

@end
